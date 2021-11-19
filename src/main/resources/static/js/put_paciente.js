window.addEventListener('load', function () {
    const formulario = document.querySelector('#update_paciente_form');
    formulario.addEventListener('submit', function (event) {
        let pacienteId = document.querySelector('#paciente_id').value;
        const formData = {
            id: document.querySelector('#paciente_id').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            domicilio: document.querySelector('#domicilio').value,
            dni: document.querySelector("#dni").value
        };
        const url = '/pacientes';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
            let paciente = data;
                    let successAlert = '<div class="alert alert-success alert-dismissible">' + 
                                            '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                            '<strong> student = </strong> ' + data.toString();
                                        '</div>'

                    // change the updated data for pelicula table record
                    $("#tr_" + pacienteId + " td.td_first_name").text(paciente.nombre);
                    $("#tr_" + pacienteId + " td.td_address").text(paciente.apellido);

                    $("#response").empty();
                    $("#response").append(successAlert);
                    $("#response").css({"display": "block"});
        
        }).catch(error => {
            let errorAlert = '<div class="alert alert-danger alert-dismissible">' + 
            '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
            '<strong> Error </strong></div>';

            $("#response").empty();                                    
            $("#response").append(errorAlert);
            $("#response").css({"display": "block"});
        })

    })
    })

          
    

    function find(id) {
        
          const url = '/pacientes'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let paciente = data;
              $("#paciente_id").val(paciente.id);
              $("#nombre").val(paciente.nombre);
              $("#apellido").val(paciente.apellido);
              $("#domicilio").val(paciente.domicilio);
              $("#dni").val(paciente.dni);
              $("#div_paciente_updating").css({"display": "block"});
          }).catch(error => {
              console.log(error);
              alert("Error -> " + error);
          })
      }