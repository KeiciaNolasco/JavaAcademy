var app = angular.module('myApp', []);

app.controller('MainController', function($scope, $http) {
    $scope.items = ['Item 1', 'Item 2', 'Item 3'];
    $scope.inputValue = '';

    $scope.handleClick = function() {
        alert('Button clicked!');
    };

    $scope.fetchData = function() {
        $http.get('https://jsonplaceholder.typicode.com/posts')
            .then(function(response) {
                $scope.posts = response.data;
            })
            .catch(function(error) {
                console.error('Error fetching data:', error);
            });
    };
});

app.directive('myDirective', function() {
    return {
        restrict: 'A',
        link: function(scope, element) {
            element.on('mouseenter', function() {
                element.css('color', 'blue');
            });
            element.on('mouseleave', function() {
                element.css('color', 'black');
            });
        }
    };
});
