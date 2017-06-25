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
    $("#addKursBtn").on("click",function(e){
        alert("!!");
    });
    $('.list-group.single-select').on("click", "a", function(e){
        e.preventDefault();
       $(this).siblings(".active").removeClass("active");
        $(this).addClass("active");
    });
    $('.pagination').on("click","li", function(e){
        that=$(this);
        that.siblings(".active").removeClass("active");
        that.addClass("active");
    });
    $('.nav.nav-tabs').on("click","li",function(e){
       that=$(this);
        that.siblings(".active").removeClass("active");
        that.addClass("active");
    });
});