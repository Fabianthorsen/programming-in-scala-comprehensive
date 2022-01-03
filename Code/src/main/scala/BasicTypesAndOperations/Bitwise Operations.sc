// Perform operations on individual bits of an integer
// Bitwise-and (&), bitwise-or (|) and bitwise-xor (^)
1 & 2 // 1 (0001) and 2 (0010), since they dont have any same bits, it is 0
1 | 2 // 1 (0001) or 2 (0010), meaning it will be (0011), so 3
1 ^ 3 // xor each bit in 1 (0001) and 3 (0011), so (0010)
~1 // inverts each bit in 1 (0001), so (11111111111111111111111111111110), so -2

// Shift methods
// Shift left (>>), shift right (<<) and unsigned shift right (<<<)'
// when used in infix notation, shift the integer value on left of the
// operator by the amount specified by the integer value on the right
// Shift left and unsigned shift right fill with zeros as they shift
// Shift right fills with the histed bit (the sign bit) on the left-hand
// value as it shifts
-1 >> 31 // -1 in binary is 11111111111111111111111111111111
// -1 is shifted 31 bit positions, since int consists of 32 bits,
// the operation effectively moves the leftmost bit over until it becomes
// the rightmost bit. Since it fills with ones as it shifts right, because
// the leftmost bit of -1 is 1.
-1 >>> 31
// This time we fill with zeros instead of ones, meaning 00000000000000000000000000000001
1 << 2
// 1 (0001) is shifted two positions so (0100) which is 4