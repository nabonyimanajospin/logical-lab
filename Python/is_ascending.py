def is_ascending(arr):
    for i in range(len(arr)-1):
        if arr[i] > arr[i+1]:
           return False
    return True

arr1 = [1,2,3,4]
arr2 = [4,3,2,1]
print(f"{arr1} -> {is_ascending(arr1)}")
print(f"{arr2} -> {is_ascending(arr2)}")