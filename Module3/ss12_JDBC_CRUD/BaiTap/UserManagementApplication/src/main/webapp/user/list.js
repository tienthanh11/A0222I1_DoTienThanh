$(function () {
    $('.btn-delete').click(function () {
        let id=$(this).data("id");
        $('.btn-confirm-delete').attr("href","/users?action=delete&id="+id);
    })
});
$('.btn-find').click(function () {
    let country=$('#find-country').val();
    $('.btn-find').attr("href","/users?action=find&id="+country);
});
$('.btn-edit').click(function () {
    let id=$(this).data("id");
    let name=$(this).data("name");
    let email=$(this).data("email");
    let country=$(this).data("country");
    $("#user_id").val(id);
    $("#user_name").val(name);
    $("#user_email").val(email);
    $("#user_country").val(country);
});