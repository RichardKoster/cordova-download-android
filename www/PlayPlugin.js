/**
 * Created by Richard on 7/23/2014.
 */
var PlayPlugin = function(){

}
PlayPlugin.play=function(){
    logger(3, "play");
    Cordova.exec("VideoPlayerPlugin", "play",null, null);
};

module.exports = PlayPlugin();
