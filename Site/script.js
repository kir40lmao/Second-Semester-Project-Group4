$( ".inner-switch" ).on("click", function() {
    if( $("header" ).hasClass( "dark" )) {
      $( "header" ).addClass( "light" );
      $( "main" ).addClass( "light" );
      $( "header" ).removeClass( "dark" );
      $( "main" ).removeClass( "dark" );
      $( ".inner-switch" ).text( "OFF" );

    } else if ($( "header" ).addClass( "dark")) {
      $( "main" ).addClass( "dark" );
      $( "header" ).removeClass( "light" );
      $( "main" ).removeClass( "light" );
      $( ".inner-switch" ).text( "ON" );

    } else { ($( "header" ).addClass( "light" )) 
    $( "main" ).addClass( "light" );
    $( ".inner-switch" ).text( "OFF" );
}
   if( $(".inner-switch" ).hasClass( "ON" )) {
    $(".inner-switch" ).removeClass( "ON" );
    $(".inner-switch" ).addClass( "OFF" );

   }
   else{
    $(".inner-switch" ).addClass( "ON" );
    $(".inner-switch" ).removeClass( "OFF" )
   }

}); 