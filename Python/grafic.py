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

df2_vals = [[0.5, 0.5, "Blue"], [0.523, 0.472, "Green"]]

df1 = pd.DataFrame(values, columns=['X', 'Y'])
df2 = pd.DataFrame(df2_vals, columns=['X', 'Y', 'Color'])


scatter_plot = plt.figure()
ax = scatter_plot.add_subplot(1, 1, 1)
ax.scatter(df1['X'], df1['Y'], s=30, color="Black")
ax.scatter(df2['X'], df2['Y'], s=30, color=df2['Color'])
scatter_plot.savefig("Graphic1.1.png")