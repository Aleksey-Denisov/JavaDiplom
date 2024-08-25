function updateEvent() {
    $.ajax({
        type: "POST",
        url: "/event/" + $('#dpe').val() + "/" + $('#type').val(),
        dataType : 'json',
        success: function(result) {
            $("#signalValue").val(result.signalValue);
            $("#timeSignal").val(result.timeSignal);
            $("#activeSig1").prop('checked', result.activeSig);
            $("#bad1").prop('checked', result.bad);
        }
    });
}
setInterval(updateEvent, 20000);