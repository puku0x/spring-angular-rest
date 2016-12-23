(function() {
  'use strict'

  // サービス登録
  angular
    .module('app')
    .factory('TodoService', Service);

  // DI
  Service.$inject = ['$http'];

  // サービス
  function Service($http) {
    var baseUrl = 'http://localhost:8080/api/v1';

    return {
      'findAll': findAll,
      'find': find,
      'save': save,
      'remove': remove
    }

    // 全件取得
    function findAll(offset, limit) {
      var config = {
        params: {
          offset: offset,
          limit: limit
        }
      };
      return $http.get(baseUrl + '/todos', config);
    }

    // 1件取得
    function find(id) {
      var config = {
        params: {
          offset: offset,
          limit: limit
        }
      };
      return $http.get(baseUrl + '/todos/' + id, config);
    }

    // 保存
    function save(todo) {
      var data = todo;
      var config = {};
      return $http.post(baseUrl + '/todos', data, config);
    }

    // 削除
    function remove(id) {
      var config = {};
      return $http.delete(baseUrl + '/todos/' + id, config);
    }
  }
})();
