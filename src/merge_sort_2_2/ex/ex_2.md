Give traces, in the style of the trace given in this section,
showing how the keys E A S Y Q U E S T I O N are sorted with 
top-down mergesort and with bottom-up mergesort.

# Top-Down
    E A S Y Q U E S T I O N

1  *A E*s y q u e s t i o n
2  *A E S*y q u e s t i o n
3   a e s*Q Y*u e s t i o n
4   a e s*Q U Y*e s t i o n
5  *A E Q S U Y*e s t i o n
6   a e q s u y*E S*t i o n
7   a e q s u y*E S T*i o n
8   a e q s u y e s t*I O*n 
9   a e q s u y e s t*I N O*
10  a e q s u y*E I N O S T*
11 *A E E I N O Q S S T U Y*


# Bottom-Up 
    E A S Y Q U E S T I O N

1  *A E*s y q u e s t i o n
2   a e*S Y*q u e s t i o n
3   a e s y*Q U*e s t i o n
4   a e s y q u*E S*t i o n
5   a e s y q u e s*I T*o n
6   a e s y q u e s i t*N O*
7  *A E S Y*q u e s i t n o
8   a e s y*E Q S U*i t n o
9   a e s y e q s u*I N O T*
10 *A E E Q S S U Y*i n o t 
11 *A E E I N O Q S S T U Y* 
