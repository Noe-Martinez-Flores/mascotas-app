const functionMoveToForm = ( ) => {
    window.location.href = document.URL + "/form";
};


const functionMoveToResult = ( ) => {
    const switchCheck = document.getElementById( "flexSwitchCheckChecked" );
    if( switchCheck.checked ){
        window.location.href = document.URL + "/adoptado";
        switchCheck.setAttribute( "checked", "" );
    }else{
        window.location.href = document.URL.replace( "adoptado", "" );
    }
};