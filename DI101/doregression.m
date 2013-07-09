function ypredicted = doregression(xtrain, ytrain, xtest) 
    model = LinearModel.fit(xtrain,ytrain); % Create the model 
    ypredicted = model.predict(xtest); % Run prediction on our training data     
end 

