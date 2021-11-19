window.addEventListener('load', function(event) {
    var form = document.getElementById('crear_turno');
    
    form.addEventListener('submit', function(event) {
        var paciente = parseInt(document.querySelector('#paciente').value);
        var odontologo = parseInt(document.querySelector('#odontologo').value);
        event.preventDefault();
        
        const urlO = '/odontologos/' + odontologo;
        const urlP = '/pacientes/' + paciente;
        const settings = { method: 'GET' }
        
        fetch(urlP,settings)
        .then(response => response.json())
        .then(data => {
            paciente = data;
            console.log(paciente);
            
            fetch(urlO,settings)
            .then(response => response.json())
            .then(data => {
                odontologo = data
                console.log(odontologo);

                const formData = {
                    paciente: paciente,
                    odontologo: odontologo,
                    fecha: document.querySelector('#fecha').value,
                    hora: document.querySelector('#hora').value,
                };
                const url = '/turnos';
                const settings2 = {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify(formData)
                }

                console.log(settings2);
        
                fetch(url, settings2)
                .then(response => response.json())
                .then(data => {
                    console.log(data);
                    let successAlert = '<div class="alert alert-success alert-dismissible">' +
                        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                        '<strong></strong> Turno agregado </div>'
                    $("#response").append(successAlert);
                    $("#response").css({"display": "block"});
        
                    resetUploadForm();
        
                })
                .catch(error => {  let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                        '<strong> Error intente nuevamente</strong> </div>'
                        $("#response").append(errorAlert);
                        $("#response").css({"display": "block"});
                        resetUploadForm();
                })
            });
            });
        });

        
        

        

    function resetUploadForm() {
        document.getElementById('paciente').value = '';
        document.getElementById('odontologo').value = '';
        document.getElementById('fecha').value = '';
        document.getElementById('hora').value = '';
    }
});