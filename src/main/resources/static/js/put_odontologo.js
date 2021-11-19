window.addEventListener('load', function () {
    const formulario = document.querySelector('#update_odontologo_form');
    formulario.addEventListener('submit', function (event) {
        let odontologoId = document.querySelector('#odontologo_id').value;
        const formData = {
            id: document.querySelector('#odontologo_id').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            matricula: document.querySelector('#matricula').value
        };
        const url = '/odontologos';
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
            let odontologo = data;
                    let successAlert = '<div class="alert alert-success alert-dismissible">' + 
                                            '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                            '<strong> student = </strong> ' + data.toString();
                                        '</div>'

                    // change the updated data for pelicula table record
                    $("#tr_" + odontologoId + " td.td_first_name").text(odontologo.nombre);
                    $("#tr_" + odontologoId + " td.td_address").text(odontologo.apellido);

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
        
          const url = '/odontologos'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let odontologo = data;
              $("#odontologo_id").val(odontologo.id);
              $("#nombre").val(odontologo.nombre);
              $("#apellido").val(odontologo.apellido);
              $("#matricula").val(odontologo.matricula);
              $("#div_odontologo_updating").css({"display": "block"});
          }).catch(error => {
              console.log(error);
              alert("Error -> " + error);
          })
      }