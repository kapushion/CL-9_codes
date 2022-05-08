from flask import Flask,jsonify,request
app = Flask(__name__)
num_win = 0
num_loss = 0
num_tie = 0
@app.route('/help',methods=['GET'])
def help():
    return jsonify({'Routes available':[{'name':'addwin','method':'POST'},{'name':'addloss','method':'POST'},
    {'name':'addtie','method':'POST'},{'name':'score','method':'GET'}]})

@app.route('/addwin',methods=['POST'])
def addwin():
    global num_win
    num_win+=1
    return jsonify({'win':num_win})

@app.route('/addloss',methods=['POST'])
def addloss():
    global num_loss
    num_loss+=1
    return jsonify({'loss':num_loss})

@app.route('/addtie',methods=['POST'])
def addtie():
    global num_tie
    num_tie+=1
    return jsonify({'tie':num_tie})

@app.route('/score',methods=['GET'])
def score():
    return jsonify({'win':num_win,'loss':num_loss,'tie':num_tie})

#driver function
if __name__ == '__main__':
    app.run(debug = True)