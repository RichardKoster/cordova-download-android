/**
 * Created by Richard on 7/23/2014.
 */
var PlayPlugin = function(){

}
PlayPlugin.play=function(successCallBack, errorCallBack){
    logger(3, "play");
    Cordova.exec(successCallBack, errorCallBack, "VideoPlayerPlugin", "play", []);
};

module.exports = PlayPlugin;
