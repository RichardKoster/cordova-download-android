var DownloadPlugin = function(){

}
DownloadPlugin.download = function (fileUrl, successCallback, errorCallback) {
	cordova.exec(successCallback, errorCallback, 'DownloadPlugin', "download", [fileUrl]);
}

module.exports = DownloadPlugin;
