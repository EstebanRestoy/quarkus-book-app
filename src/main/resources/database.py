import json
import sqlite3

connection = sqlite3.connect('database.db')
cursor = connection.cursor()
cursor.execute('Create Table if not exists Livre(id INTEGER PRIMARY KEY AUTOINCREMENT, titre Text, image Text, auteur Text, editeur Text, date Text, prix Text)')

traffic = json.load(open('books.json'))
columns = ['titre', 'image', 'auteur', 'editeur', 'date', 'prix']
index = 1
for row in traffic:
    keys = tuple(row[c] for c in columns)
    cursor.execute('insert into Livre(titre, image, auteur, editeur, date, prix) values(?,?,?,?,?,?)', keys)
    print(f'{row["titre"]} data inserted Succesfully')
    print("================================================================")

connection.commit()
connection.close()