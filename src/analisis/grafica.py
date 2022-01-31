import matplotlib.pyplot as plt;

x=[10000,100000,1000000,10000000]

y1=[4,8,76.4,660.4]
y2=[3,11.2,71.2,672.4]
# y3=[21.6,183.6,1869.6,30993]
y4=[20,25.2,31.4,35.1]
y5=[6,9.3,29,475.5]
y6=[1,1,1,1]
y7=[3.3,9.6,21.6,75.3]

plt.xlim(10000,10000000)

plt.plot(x, y1, label = "Creación de una cola de tamaño n")
plt.plot(x, y2, label = "Creación de una pila de tamaño n")
# plt.plot(x, y3, label = "Creación de un arbol AVL de tamaño n")
plt.plot(x, y4, label = "Busqueda por elemento arbol AVL")
plt.plot(x, y5, label = "Creación de tabla hash de tamaño n")
plt.plot(x, y6, label = "Busqueda por llave tabla hash")
plt.plot(x, y7, label = "Busqueda por elemento lista doble enlazada")

plt.xlabel('Tamaño de datos de prueba')
plt.ylabel('Tiempo de ejecución en milisegundos')
plt.title('Análisis asintótico')

plt.legend(loc = "upper left")
plt.savefig('data/graficas.png')


