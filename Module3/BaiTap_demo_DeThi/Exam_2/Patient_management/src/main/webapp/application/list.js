$(document).ready(function () {
    const valid_id_object = /^[Bb][aA]-\d{3}$/;
    const validEmail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

    // !validName.test(firstName))
    //set key,value when send redirect to jsp
    //show modal when need to appear
    // $("#createObjectModal").modal('show');
    //change color when click pagnition
    let options = document.querySelectorAll('.pagination-link');
    let valuePage = $('#nav-page').data("id");
    for (let i = 0; i < options.length; i++) {
        console.log(options[i].value);
        if (options[i].textContent == valuePage) {
            options[i].style.color = "white";
            options[i].style.backgroundColor = "blue";
        }
    }
    ;

    // validate
    $('.id-object').on('input',function (){
        let id=$(this).val();
        if(id.length==0){
            $('.object-msg').addClass('invalid-msg').text("ID is required");
            $(this).addClass('invalid-input').removeClass('valid-input');
        }
        else if(!id.match(valid_id_object)){
            $('.object-msg').addClass('invalid-msg').text("ID is required start BA- and three number behind");
            $(this).addClass('invalid-input').removeClass('valid-input');
        }else {
            $('.object-msg').empty();
            $(this).addClass('valid-input').removeClass('invalid-input');

        }
    });
    $('.date-in').on('change',function () {
        let date_in=$('#myForm .date-in').val();
        let date_out=$('#myForm .date-out').val();
        date_in.Date.prototype.getTime() === date_out.Date.prototype.getTime();
        // if (date_in>date_out){
        //     $('.dateout-msg').addClass('invalid-msg').text("Date in must be lower date out");
        //     $('.date-out').addClass('invalid-input').removeClass('valid-input');
        // }
        // else {
        //     $('.dateout-msg').empty();
        //     $('.date-out').addClass('valid-input').removeClass('invalid-input');
        // }
    });
    $('.date-out').on('change',function () {
        let date_in=$('#myForm .date-in').val();
        let date_out=$('#myForm .date-out').val();
        date_in.Date.prototype.getTime() === date_out.Date.prototype.getTime();
        // if (date_in>date_out){
        //     $('.dateout-msg').addClass('invalid-msg').text("Date in must be lower date out");
        //     $(this).addClass('invalid-input').removeClass('valid-input');
        //
        // }
        // else {
        //     $('.dateout-msg').empty();
        //     $(this).addClass('valid-input').removeClass('invalid-input');
        // }
    });


    // validation to submit the form
    $('#myForm').on('change',function(e){
        if($('#myForm').find('.valid-input').length==2){
            $('#submit-btn').removeClass('allowed-submit');
            $('#submit-btn').removeAttr('disabled');
        }
        else{
            e.preventDefault();
            $('#submit-btn').attr('disabled','disabled');
            $('#submit-btn').addClass('allowed-submit');
        }
    });

    // crate function delete
    $('.btn-delete').click(function () {
        let id = $(this).data("id");
        $('.btn-confirm-delete').attr("href", "/application?action=delete&id=" + id);
    });
    // create button edit
    $('.btn-edit').click(function () {
        let object = $(this).data("object");
        let people = $(this).data("people");
        let datein = $(this).data("datein");
        let dateout = $(this).data("dateout");
        let reason = $(this).data("reason");
        $("#id-object").val(object);
        $("#id-object-disable").val(object);
        $("#id-patience").val(people);
        $("#id-patience-disable").val(people);
        $("div .set-select select").val(people);
        $("#date-in").val(datein);
        $("#date-out").val(dateout);
        $("#reason-input").val(reason);
    });
    $('.confirm-edit').click(function () {
        $('#form_edit').attr("action", "/application?action=edit&id=" + object);
    });
    //tao function search
    $('.btn-search').click(function () {
        let key = $('#select-sort').val();
        let value = $('#input-search').val();
        $('.btn-search').attr('type', 'submit');
        debugger;
        if (value == null || value == "") {
            $('#form-search').attr('action', '/application');

        } else if (value != null && key == "All") {
            var val = value.toLowerCase();
            $("#myTable tr").filter(function () {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
            });
            $('#form-search').attr('action', '/application?action=');
            $('.btn-search').attr('type', 'button');

        } else {
            $('#form-search').attr('action', '/application?action=search&key=' + key + '&value=' + value);
        }
    });
});