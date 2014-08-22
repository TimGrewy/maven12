// Code goes here

var getAllMessages = function($scope, $http){
  //Allow cross site gets
  $http.defaults.useXDomain = true;
  var url = '/maven12/rest/messages';
  
  $http({
    method: 'GET',
    url: url
  }).
  success(function(data, status, headers, config) {
    $scope.messages = data;
  }).
  error(function(data, status, headers, config) {

    $scope.error = 'Error: Status: ' + status;
  });
}

var MainController = function($scope, $http) {
  //Allow cross site gets
  $http.defaults.useXDomain = true;

  getAllMessages($scope, $http);

  var createUrl = '/maven12/rest/message/create/';
  
  $scope.createMessage = function(newMessage) {
    $http.defaults.useXDomain = true;
    var combinedCreateUrl = createUrl + newMessage;
    $http({
      method: 'POST',
      url: combinedCreateUrl
    }).
  success(function(data, status, headers, config) {
      getAllMessages($scope, $http);
    }).
    error(function(data, status, headers, config) {
      
      $scope.error = 'Error: Status: ' + status;
    });
  };

}