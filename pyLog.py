import matplotlib.pyplot as plt
import numpy as np

x = np.linspace(1.2,3200,3200)

y = x*np.log2(x)

#x = np.log2(x)

#y = np.log2(y)

plt.axis([-0, 4, -0, 12])
plt.grid()
plt.plot(x,y)
plt.show()
