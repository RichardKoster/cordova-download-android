var downloadplugin = {
    download: function(fileUrl, successCallback, errorCallback){
        cordova.exec(successCallback, errorCallback, 'DownloadPlugin',"download",[fileUrl]);
    }
}