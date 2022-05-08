from flask import Flask,jsonify,make_response
import requests
import os
import simplejson as json

app=Flask(__name__)

with open ("users.json","r") as f:
    user = json.load(f)

@app.route("/",methods=['GET'])
def welcome():
    return "Welcome"

@app.route("/users",methods=['GET'])
def users():
    resp = make_response(json.dumps(user,sort_keys=True,indent=4))
    resp.headers['Content-Type']="application/json"
    return resp 

@app.route("/users/<username>",methods=['GET'])
def user_data(username):
    if username not in user:
        return "Not found"
    else:
        return jsonify(user[username])

with open("todo.json","r") as f:
    todo_list = json.load(f)

@app.route("/users/<username>/lists",methods=['GET'])
def user_list(username):
    if username not in todo_list:
        return "no user found"
    else:
        return jsonify(todo_list[username])
    
if __name__=='__main__':
    app.run(port=5001,debug=True)



