window.addEventListener('load', function () {

    (function(){
      event.preventDefault();
      const url = '/turnos/list';
      const settings = {
        method: 'GET'
    }
      fetch(url,settings)
      .then(response => response.json())
      .then(data => {
        $.each(data, (i, turno) => {
        
          let deleteButton = '<button ' +
                                  'id=' +
                                  '\"' + 'btn_delete_' + turno.id + '\"'+
                                  ' type="button" class="btn btn-danger btn_delete" data-toggle="modal"  data-target="#delete-modal"' +
                                  '><i class="far fa-trash-alt"></i></button>';
    
          let get_More_Info_Btn = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + turno.id + '\"' +
                                      ' type="button" onclick="find('+turno.id+')" class="btn btn-info btn_id"><i class="far fa-edit"></i></button>';
          
          let tr_id = 'tr_' + turno.id;
          let studentRow = '<tr id=\"' + tr_id + "\"" + '>' +
                    '<td>' + turno.paciente.nombre + ' ' + turno.paciente.apellido + '</td>' +
                    '<td>' + turno.odontologo.nombre + ' ' + turno.odontologo.apellido + '</td>' +
                    '<td>' + turno.fecha + '</td>' +
                    '<td>' + turno.hora + '</td>' +
                    '<td>' + deleteButton + '</td>' +
                    '</tr>';                
          $('#turnosTable tbody').append(studentRow);
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
