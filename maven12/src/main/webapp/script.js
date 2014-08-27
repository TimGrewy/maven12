// Creating in this plunk - http://plnkr.co/edit/RQrvGrgSCBZuwS1WG7qK?p=preview

var app = angular.module("chat", ['luegg.directives']);

var MainController = function($scope, $http, $interval) {
    $http.defaults.useXDomain = true;
    var baseUrl = 'http://localhost:8080';
    var baseUrl = 'http://grewy.dk';
    $scope.pageLoads = 0;
   
    $scope.getAllMessages = function($scope, $http) {
    //Allow cross site gets
    $http.defaults.useXDomain = true;
    var url = baseUrl + '/maven12/rest/messages';

    $http({method: 'GET', url: url})
    .success(function(data, status, headers, config) {
      $scope.messages = data;
      $scope.error = '';
    })
    .error(function(data, status, headers, config) {
      $scope.error = 'Error: Status: ' + status;
    });
  }

  $scope.createMessage = function(newMessage) {
    var createUrl = baseUrl + '/maven12/rest/message/create/';
    var combinedCreateUrl = createUrl + newMessage;
    $http({
      method: 'POST',
      url: combinedCreateUrl
    }).
    success(function(data, status, headers, config) {
      $scope.getAllMessages($scope, $http);
      $scope.newMessage = '';
    }).
    error(function(data, status, headers, config) {

      $scope.error = 'Error: Status: ' + status;
    });
  };
  
  $scope.refreshPage = function(){
    $scope.getAllMessages($scope, $http);
    $scope.pageLoads += 1;
  }
  

  $scope.getAllMessages($scope, $http);
  
  $interval($scope.refreshPage, 2000);

}

  app.controller("MainController", MainController);