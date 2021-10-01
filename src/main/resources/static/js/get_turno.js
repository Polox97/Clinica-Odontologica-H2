window.addEventListener('load', function () {

    (function(){
      event.preventDefault();
      const url = '/odontologos/list';
      const settings = {
        method: 'GET'
    }
      fetch(url,settings)
      .then(response => response.json())
      .then(data => {
          console.log(data);
        $.each(data, (i, odontologo) => {
        
          let deleteButton = '<button ' +
                                  'id=' +
                                  '\"' + 'btn_delete_' + odontologo.id + '\"'+
                                  ' type="button" class="btn btn-danger btn_delete" data-toggle="modal"  data-target="#delete-modal"' +
                                  '>&times</button>';
    
          let get_More_Info_Btn = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + odontologo.id + '\"' +
                                      ' type="button" onclick="find('+odontologo.id+')" class="btn btn-info btn_id">' +
                                      "edit" +
                                      '</button>';
          
          let tr_id = 'tr_' + odontologo.id;
          let studentRow = '<tr id=\"' + tr_id + "\"" + '>' +
                    '<td class=\"td_first_name\">' + odontologo.nombre + '</td>' +
                    '<td class=\"td_address\">' + odontologo.apellido + '</td>' +
                    '<td>' + odontologo.matricula + '</td>' +
                    '<td>' + get_More_Info_Btn + '</td>' +
                    '<td>' + deleteButton + '</td>' +
                    '</tr>';                
          $('#odontologosTable tbody').append(studentRow);
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
