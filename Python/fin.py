###
### CS667 Data Science with Python, Homework 6, Jon Organ
###

from musicRec import music_rec
import pandas as pd
df = pd.read_csv("data_music.csv")
sample_song = df.iloc[0]


mRec = music_rec("data_music.csv")
print(mRec.SongRec(sample_song))
print(mRec.UserRec("asd"))


