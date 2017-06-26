$(document).ready(function(){
    $('[data-toggle="popover"]').popover();
    var loc=window.location.toString();
    if(loc.indexOf("/student/finansije")!=-1){
        finansijeTab=$("nav.nav.nav-tabs li:nth-child(2)");
        finansijeTab.siblings(".active").removeClass("active");
        finansijeTab.addClass("active");
    }else if (loc.indexOf("/student/profil")!=-1){
        var profilTab=$("nav.nav.nav-tabs li:nth-child(3)");
        profilTab.siblings(".active").removeClass("active");
        profilTab.addClass("active");
    }else if(loc.indexOf("/student/studije")!=-1){
        var studijeTab=$("nav.nav.nav-tabs li:nth-child(1)");
        studijeTab.siblings(".active").removeClass("active");
        studijeTab.addClass("active");
    }
    
    
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
    $("nav.nav.nav-tabs").on("click","li",function(e){
       that=$(this);
        that.siblings(".active").removeClass("active");
        that.addClass("active");
    });
});