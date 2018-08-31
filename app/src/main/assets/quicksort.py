def sort(array=[12,4,5,6,7,3,1,15]):#1
    less = []#2,3,4
    equal = []#2,3,4
    greater = []#2,3,4
    if len(array) > 1:#5
        pivot = array[0]#-6
        for x in array:#7
            if x < pivot:#-8
                less.append(x)#9
            if x == pivot:#-10
                equal.append(x)#11
            if x > pivot:#12
                greater.append(x)#13
        return sort(less)+equal+sort(greater)#14
    else:#15
        return array#16
//DESCRIPTION:
Create a recursive Python function that implements quicksort.