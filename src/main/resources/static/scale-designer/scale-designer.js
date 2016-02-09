
var MAX_SCALE_CENTS = 1200;

app.controller('scales', function($scope, $routeParams, $http) {
    $scope.name = "scales";
    $scope.params = $routeParams;

    // Load data
    $http.get('/api/scales').success(function(data) {
        $scope.scales = data;
        $scope.editing = null;
    });
    $http.get('/api/scales/selected').success(function(data) {
        $scope.selected = data.id;
    });


    // Select scale
    $scope.setSelectedScale = function(scale) {
        $http.put('/api/scales/selected', scale).success(function(data) {
            $scope.selected = scale.id;
        });
    };

    $scope.addScale = function() {
        var scale = {name:"New Scale", cents:[0, 1200]};
        $scope.scales.push(scale);
        $scope.editScale(scale);
    };



    // Edit scale
    $scope.editScale = function(scale) {
        $scope.editing = angular.copy(scale);
        createMultiRangeArray($scope.editing);
    };

    $scope.addCent = function() {
        $scope.editing.cents.push($scope.editing.cents[$scope.editing.cents.length-1]);
        createMultiRangeArray($scope.editing);
    };

    $scope.deleteCent = function(centIndex) {
        $scope.editing.cents.splice(centIndex, 1);
        createMultiRangeArray($scope.editing);
    };

    $scope.equalizeScale = function() {
        var noteCount = $scope.editing.cents.length-1;
        var octave = $scope.editing.cents[noteCount];
        var interval = octave/noteCount;
        for(var i=1; i<=noteCount; i++) {
            $scope.editing.cents[i] = Math.round(interval * i * 100)/100;
        }
        createMultiRangeArray($scope.editing);
    };

    $scope.saveScale = function(scaleIndex) {
        $http.post('/api/scales', $scope.editing).success(function(data) {
            $scope.scales[scaleIndex] = data;
            $scope.editing = null;
        });
    };

    $scope.centToPercent = function(cents) {
        return (cents/(MAX_SCALE_CENTS/100))+'%';
    };

    $scope.onMultiRangeMouseMove = function() {
        if($scope.mousedown) {
            createCentsFromMultiRange($scope.editing);
        }
    };

    $scope.onMultiRangeMouseDown = function() {
        $scope.mousedown = true;
    };

    $scope.onMultiRangeMouseUp = function() {
        $scope.mousedown = false;
    };

    $scope.onCentChange = function(centIndex) {
        createMultiRangeArray($scope.editing);
    };
});


var createMultiRangeArray = function(scale) {
    scale.multirange = [];
    for(var i=1; i<scale.cents.length; i++) {
        scale.multirange.push({ value:scale.cents[i]/MAX_SCALE_CENTS });
    }
};

var createCentsFromMultiRange = function(scale) {
    for(var i=1; i<scale.cents.length; i++) {
        scale.cents[i] = Math.round(scale.multirange[i-1].value*MAX_SCALE_CENTS);
    }
    scale.cents.sort(function(a, b) {return a-b;});
};