define(["angular","skybox/SkyBox"],
        function(angular,SkyBoxDef){ // SkyBoxDef is a function constructing the SkyBox class
            var skyBoxModule = angular.module('SkyBox',[]);
            skyBoxModule.factory('skyBox',['mediaPath','threeDScene',function(mediaPath,threeDScene){
                var injectables = { 'basePath': mediaPath };
                var SkyBox = SkyBoxDef(injectables); // SkyBoxDef is a function constructing the SkyBox class
                var skyBox = new SkyBox({x: 0, y: 0, z: 0});
                skyBox.basePath = mediaPath;
                threeDScene.addActor(skyBox);
                return skyBox;
            }])
            ;
});