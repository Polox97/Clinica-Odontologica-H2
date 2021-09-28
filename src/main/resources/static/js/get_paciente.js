window.addEventListener('load', function () {

    (function(){
      event.preventDefault();
      const url = '/pacientes/list';
      const settings = {
        method: 'GET'
      }
      fetch(url,settings)
      .then(response => response.json())
      .then(data => {
          console.log(data);
        $.each(data, (i, paciente) => {
        
          let deleteButton = '<button ' +
                                  'id=' +
                                  '\"' + 'btn_delete_' + paciente.id + '\"'+
                                  ' type="button" class="btn btn-danger btn_delete" data-toggle="modal"  data-target="#delete-modal"' +
                                  '>&times</button>';
    
          let get_More_Info_Btn = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + paciente.id + '\"' +
                                      ' type="button" onclick="find('+paciente.id+')" class="btn btn-info btn_id">' +
                                      "edit" +
                                    '</button>';
          
          let tr_id = 'tr_' + paciente.id;
          let studentRow = '<tr id=\"' + tr_id + "\"" + '>' +
                    '<td class=\"td_first_name\">' + paciente.nombre + '</td>' +
                    '<td class=\"td_address\">' + paciente.apellido + '</td>' +
                    '<td>' + paciente.domicilio + '</td>' +
                    '<td>' + paciente.dni + '</td>' +
                    '<td>' + paciente.fechaAlta + '</td>' +
                    '<td>' + get_More_Info_Btn + '</td>' +
                    '<td>' + deleteButton + '</td>' +
                    '</tr>';                
          $('#pacientesTable tbody').append(studentRow);
        });
    
      })
    })
    
    (function(){
      let pathname = window.location.pathname;
      if (pathname == "/studentsList.html") {
          $(".nav .nav-item a:last").addClass("active");
      }
    })
});
