###
### CS667 Data Science with Python, Homework 6, Jon Organ
###

import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
import sys, math

def G1():
	values = np.random.rand(100, 2)
	i = 0
	while i < 100:
		distance = math.sqrt(((values[i][0] - 0.5) ** 2) + ((values[i][1] - 0.5) ** 2))
		if distance < 0.05:
			if i % 4 < 2:
				if i % 2 == 0:
					values[i][0] += 0.2
				else:
					values[i][0] -= 0.2
			else:
				if i % 2 == 0:
					values[i][1] += 0.2
				else:
					values[i][1] -= 0.2
		i += 1

	df2_vals = [[0.5, 0.5, "Blue"], [0.523, 0.472, "Green"]]

	df1 = pd.DataFrame(values, columns=['X', 'Y'])
	df2 = pd.DataFrame(df2_vals, columns=['X', 'Y', 'Color'])


	scatter_plot = plt.figure()
	ax = scatter_plot.add_subplot(1, 1, 1)
	ax.scatter(df1['X'], df1['Y'], s=30, color="Black")
	ax.scatter(df2['X'], df2['Y'], s=30, color=df2['Color'])
	scatter_plot.savefig("Graphic1.1.png")


values = np.random.rand(100, 2)
i = 0
while i < 100:
	distance = math.sqrt(((values[i][0] - 0.5) ** 2) + ((values[i][1] - 0.5) ** 2))
	if distance < 0.05:
		if i % 4 < 2:
			if i % 2 == 0:
				values[i][0] += 0.2
			else:
				values[i][0] -= 0.2
		else:
			if i % 2 == 0:
				values[i][1] += 0.2
			else:
				values[i][1] -= 0.2
	i += 1

df2_vals = [ [0.523, 0.472, "Green"]]
values2 = [[0.5, 0.5, "Blue"],
 [0.53618101, 0.82058832, "Orange"],
 [0.44827622, 0.97632013, "Orange"],
 [0.32630899, 0.17523049, "Orange"],
 [0.43590857, 0.87384474, "Orange"],
 [0.48516148, 0.84321932, "Orange"],
 [0.73887531, 0.1828456, "Orange" ],
 [0.59860684, 0.55139414, "Green"],
 [0.04776796, 0.92647465, "Orange"],
 [0.81946045, 0.20944889, "Orange"],
 [0.34824694, 0.29644583, "Orange"]]

values3 = [[0.5, 0.5], [0.59860684, 0.55139414]]


df1 = pd.DataFrame(values, columns=['X', 'Y'])
df2 = pd.DataFrame(values2, columns=['X', 'Y', 'Color'])
df3 = pd.DataFrame(values3, columns=['X', 'Y'])


scatter_plot = plt.figure()
ax = scatter_plot.add_subplot(1, 1, 1)
ax.scatter(df1['X'], df1['Y'], s=30, color="Black")
ax.scatter(df2['X'], df2['Y'], s=30, color=df2['Color'])
ax.plot(df3['X'], df3['Y'])
scatter_plot.savefig("Graphic2.1.png")



