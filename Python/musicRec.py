###
### CS667 Data Science with Python, Final Project, Jon Organ
###


import pandas as pd
from sklearn.neighbors import KNeighborsClassifier

class music_rec:
	def __init__(self, file_name):
		self.df = pd.read_csv(file_name)


	def SongRec(self, song_info):
		#closest = temp.iloc[(temp["Age"]-row["Age"]).abs().argsort()[:5]]
		temp_df = self.df.drop(self.df[self.df.name == song_info.name].index)
		closest = self.df.iloc[(self.df["valence"]-song_info["valence"]
			).abs().argsort()[:1]]
		print(song_info)
		print(closest)
		return closest


	def UserRec(self, user_info):
		return "Some song from user info"


# Recommendation based off a single song
# Recommendation based off listening history

# Classifiers - Observations (valence, year, acousticness, danceability, duration_ms, energy, explicit,
# instrumentalness, key, liveness, loudness, mode, popularity, speechiness, tempo), Prediction (Good, Bad)
# name, artists
	# kNN (based off single or user history)
		# kNN with all features
		# kNN without duration_ms, explicit, key, and mode
		# kNN with all features and varying weights on features
		# Anti-kNN, users can also mention songs they don't like to avoid that type of rec
	# Logistic regression (user history only)
	# Centroid (user history only)