window.addEventListener('load', function(event) {
    var form = document.getElementById('crear_turno');
    
    form.addEventListener('submit', function(event) {
        var paciente = parseInt(document.querySelector('#paciente').value);
        var odontologo = parseInt(document.querySelector('#odontologo').value);
        event.preventDefault();
        const formData = {
            paciente_id: paciente,
            odontologo_id: odontologo,
            fecha: document.querySelector('#fecha').value,
            hora: document.querySelector('#hora').value,
        };

        console.log(formData);

        const url = '/turnos';

        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }

        console.log(settings);

        fetch(url, settings)
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

    function resetUploadForm() {
        document.getElementById('paciente').value = '';
        document.getElementById('odontologo').value = '';
        document.getElementById('fecha').value = '';
        document.getElementById('hora').value = '';
    }
});