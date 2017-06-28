(function (angular) {
	angular.module('predavac',['pohadjanja.resource','predavac.resource','predmet.resource','student.resource','kurs.resource'])
	.controller('PredavacCtrl', function($scope, $location,Predmet ,Predavac,$localStorage,$http) {

		var loadEntries = function () {
			
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
		    
					
			$scope.predavac = new Predavac.get({username: $localStorage.currentUser.username});
			console.log($scope.predavac);
		}
		loadEntries();
	
        $scope.alert = function() {
            alert("!!!");
        }
		$scope.save = function () {
			if(!$scope.blogEntry._id){
				$scope.blogEntry.$save(loadEntries);
			}
			else{
				$scope.blogEntry.$update(loadEntries);				
			}
		} 
		$scope.delete = function (blogEntry) {
			blogEntry.$delete(loadEntries);
		}
		$scope.edit = function (blogEntry) {
			$scope.blogEntry = blogEntry;
		}
	    $scope.details = function (blogEntry) {
	      $location.path('/blogEntries/'+blogEntry._id);
	    }
	    $scope.kurseviPredmeta = function(idPredmeta){
	    	console.log("aa");
	      
	     
	      $scope.kurseviSelektovanogPredmeta= new Predmet.get({id:idPredmeta})
	      console.log($scope.kurseviSelektovanogPredmeta);

	      
	        
	    };
	    
		
	})
	.controller('kursCtrl', function($scope, $location,Predmet,Student,Pohadjanja ,Kurs,Predavac,$localStorage,$http){
		
		$scope.pohadjanje = new Pohadjanja();
		$scope.izborKursa = function(idKursa){
			console.log("aaaaaa");
	    	
		      
		     
		      
		      $scope.sviStudent = new Student.query();
		      $scope.pohadjanje.$findByKurs({'idKursa':idKursa}).then(function(item){
		    	 
	                
	                $scope.pohadjanja = item;
	                $scope.obaveze= $scope.pohadjanja.pohadjanja[0].polaganje.predispitneObaveze;
	                console.log($scope.obaveze);
	                console.log($scope.pohadjanja);
	 
	            });
		      
		      
		      
		     
		     
		     

		      
		        
		    };
	});
	
}(angular));


