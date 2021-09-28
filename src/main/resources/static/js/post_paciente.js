window.addEventListener('load', function(event) {
    var form = document.getElementById('crear_paciente');
    form.addEventListener('submit', function(event) {
        event.preventDefault();
        const formData = {
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            domicilio: document.querySelector('#domicilio').value,
            dni: document.querySelector('#dni').value
        };

        const url = '/pacientes';

        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
        .then(response => response.json())
        .then(data => {
            console.log(data);
            let successAlert = '<div class="alert alert-success alert-dismissible">' +
                '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                '<strong></strong> Odontólogo agregado </div>'
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
        document.getElementById('nombre').value = '';
        document.getElementById('apellido').value = '';
        document.getElementById('domicilio').value = '';
        document.getElementById('dni').value = '';
    }
});