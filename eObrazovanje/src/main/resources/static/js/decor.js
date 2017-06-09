$(document).ready(function(){
    $('[data-toggle="popover"]').popover();
    
    
    $("#sviStudenti a,#upisaniStudenti a").on("click",function(e){
        e.preventDefault();
        that=$(this);
        if(that.hasClass("active")){
            that.removeClass("active");
        }else{
            that.addClass("active");
        }
    });
});