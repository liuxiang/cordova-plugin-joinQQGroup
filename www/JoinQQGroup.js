var cordova = require('cordova');

var JoinQQGroup = function () {
};

JoinQQGroup.prototype.open = function (commandJson, success, error) {
  cordova.exec(success, error, 'JoinQQGroup', 'open', [commandJson]);
}

var JoinQQGroup = new JoinQQGroup();
module.exports = JoinQQGroup;
