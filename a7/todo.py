import simplejson as json
from flask import Flask,jsonify,make_response
app = Flask(__name__)
import users

with open("todo.json","r") as f:
    todo_list = json.load(f)

@app.route("/",methods=['GET'])
def Hello():
    return "Todo service is up"

@app.route("/lists/<username>",methods=['GET'])
def user_list(username):
    if username not in todo_list:
        return "user not found"
    else:
        return jsonify(todo_list[username])

if __name__=='__main__':
    app.run(port=5000,debug=True)



