var DownloadPlugin = function(){

}
DownloadPlugin.prototype.download = function (fileUrl, successCallback, errorCallback) {
	cordova.exec(successCallback, errorCallback, 'DownloadPlugin', "download", [fileUrl]);
}

module.exports = DownloadPlugin;
