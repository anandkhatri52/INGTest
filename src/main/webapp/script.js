// Instantiate the app,
// match what is in ng-app
var myApp = angular.module('myApp', []);

// Create the controller,
myApp.controller('atmCtrl', function ($scope,$http) {


    $scope.myError=false;
    $scope.myCity=false;

    //oAuth Login
    $scope.oauthLogin = function () {
        $http({
            method: 'POST',
            url: 'http://localhost:8080/oauth/token?grant_type=password&username=' + this.atm.username +'&password=' + this.atm.password,
            headers:{
                'Authorization':'Basic N2I1YTM4NzA1ZDdiMzU2MjY1NTkyNTQwNmE2NTJlMzI6NjU1ZjUyMzEyODIxMmQ2ZTcwNjM0NDQ2MjI0YzJhNDg='
            }
        }).success(function (data) {
            console.log("Success response",data);
            $scope.myError=false;
            $scope.getAtms(data.access_token)
        }).error(function (data) {
            console.log("An error has occurred",data);
            $scope.err={
                msg:data.error_description
            };
            $scope.myError=true;
            $scope.myCity=false;
        });
    }

    // Get atms by city name
    $scope.getAtms = function (accessToken) {
        $http({
            method: 'GET',
            url: 'http://localhost:8080/camel/',
            headers:{
                'Authorization':'bearer '+accessToken
            }
        }).success(function (data) {
            $scope.myCity=true;
            $scope.atms=data;
        }).error(function (data) {
            console.log("An error has occurred",data);
            $scope.err={
                msg:"An error has occurred while loading atms list"
            };
            $scope.myError=true;
        });
    };

});