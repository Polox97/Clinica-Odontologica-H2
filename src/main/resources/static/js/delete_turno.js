$(document).ready(function(){
    let turnoId = 0;

    $(document).on("click", "table button.btn_delete", function() {
        let btn_id = (event.srcElement.id);
        turnoId = btn_id.split("_")[2];
        //console.log(studentId);

        $("div.modal-body")
            .text("Queres eliminar el turno con id = " + turnoId + " ?");
        $("#model-delete-btn").css({"display": "inline"});
    });

    $(document).on("click", "#model-delete-btn", function() {
        $.ajax({
            url: '/turnos/' + turnoId,
            type: 'DELETE',
            success: function(response) {
                $("div.modal-body")
                    .text("Eliminado correctamente !");

                $("#model-delete-btn").css({"display": "none"});
                $("button.btn.btn-secondary").text("Close");

                // delete the pelicula row on html page
                let row_id = "tr_" + turnoId;
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