$(document).ready(function(){
    let odontologoId = 0;

    $(document).on("click", "table button.btn_delete", function() {
        let btn_id = (event.srcElement.id);
        odontologoId = btn_id.split("_")[2];
        //console.log(studentId);

        $("div.modal-body")
            .text("Queres eliminar el estudiante con id = " + odontologoId + " ?");
        $("#model-delete-btn").css({"display": "inline"});
    });

    $(document).on("click", "#model-delete-btn", function() {
        $.ajax({
            url: '/odontologos/' + odontologoId,
            type: 'DELETE',
            success: function(response) {
                $("div.modal-body")
                    .text("Eliminado correctamente !");

                $("#model-delete-btn").css({"display": "none"});
                $("button.btn.btn-secondary").text("Close");

                // delete the pelicula row on html page
                let row_id = "tr_" + odontologoId;
                $("#" + row_id).remove();
                $("#div_pelicula_updating").css({"display": "none"});
            },
            error: function(error){
                console.log(error);
                $("#div_pelicula_updating").css({"display": "none"});
                alert("Error -> " + error);
            }
        });
    });
});