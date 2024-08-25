jQuery(document).ready(function($) {
    $('.type_spoiler_title').click(function() {
        $(this).parents('.type_spoiler').find('.type_spoiler_content').toggleClass('open');
        $(this).parents('.type_spoiler').find('.type_spoiler_arrow').toggleClass('open');
    });
    $('.dp_spoiler_title').click(function() {
        $(this).parents('.dp_spoiler').find('.dp_spoiler_content').toggleClass('open');
        $(this).parents('.dp_spoiler').find('.dp_spoiler_arrow').toggleClass('open');
    });
});