$(document).ready(function(){
    $("input[name=cantidad]").change(function(){
		idProducto = $('#producto').val();
        url = '/compra/busqueda?id='+idProducto;
        console.log('ingresa a javascript')

        var cant =  $('input[name=cantidad]').val();
        if($('input[name=cantidad]').val() != 0){
            url = url+'&cant='+$('input[name=cantidad]').val();
            console.log(url);
            $('.bloque-total').load(url);
        }

    });    
});
