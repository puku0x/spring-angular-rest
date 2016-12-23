(function() {
  'use strict'

  // コントローラ登録
  angular
    .module('app')
    .controller('TodoController', Controller);

  // DI
  Controller.$inject = ['$log', 'TodoService'];

  // コントローラ
  function Controller($log, TodoService) {
    var vm = this;
    vm.init = init;
    vm.add = add;
    vm.remove = remove;
    vm.todos = [];

    // 全件取得のパラメータ
    var offset = 0;
    var limit = 100;

    // 読み込み
    function load() {
      TodoService.findAll(offset, limit).then(function(response) {
        vm.todos = response.data.content;
      });
    }

    // 登録
    function add(content) {
      var todo = {
        content: content
      }
      TodoService.save(todo).then(function(response) {
        load();
      });
    }

    // 削除
    function remove(todo) {
      TodoService.remove(todo.id).then(function(response) {
        load();
      });
    }

    // 初期化
    function init() {
      load();
    }
  }
})();
