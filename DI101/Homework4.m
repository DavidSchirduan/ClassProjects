%a program to complete DI Homework 4
%David Schirduan

redds = dataset('File','winequality-red.csv','delimiter',';');
redds.Properties.VarNames;
redX = [redds.fixedAcidity redds.volatileAcidity];
redy = redds.quality;
redmodel = LinearModel.fit(redX,redy);
redcp = cvpartition(length(redy),'k',10);
redcvMSE = crossval('mse',redX,redy,'predfun', @doregression,'partition',redcp);
redcvR2 = 1 - redcvMSE/mean((redy - mean(redy)).^2);



whiteds = dataset('File','winequality-white.csv','delimiter',';');
whiteds.Properties.VarNames;
whiteX = [whiteds.fixedAcidity whiteds.volatileAcidity];
whitey = whiteds.quality;
whitemodel = LinearModel.fit(whiteX,whitey);
whitecp = cvpartition(length(whitey),'k',10);
whitecvMSE = crossval('mse',whiteX,whitey,'predfun', @doregression,'partition',whitecp);
whitecvR2 = 1 - whitecvMSE/mean((whitey - mean(whitey)).^2);