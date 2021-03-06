package kotlin.expectations

import kotlin.test.assertTrue

fun Expectation<Long>.toBeGreaterOrEqualTo(val value: Long) : ExpectationChain<Long> {
    assertTrue(target >= value)
    return ExpectationChain(this)
}

fun Expectation<Long>.toBeGreaterThan(val value: Long) : ExpectationChain<Long> {
    assertTrue(target > value)
    return ExpectationChain(this)
}

fun Expectation<Long>.toBeLessOrEqualTo(val value: Long) : ExpectationChain<Long> {
    assertTrue(target <= value)
    return ExpectationChain(this)
}

fun Expectation<Long>.toBeLessThan(val value: Long) : ExpectationChain<Long> {
    assertTrue(target < value)
    return ExpectationChain(this)
}

fun Expectation<Long>.toBeInRange(val lower: Long, val upper: Long) : ExpectationChain<Long> {
    assertTrue(target >= lower && target <= upper)
    return ExpectationChain(this)
}

fun Expectation<Long>.toBeApproximately(val value: Long, val tolerance: Long) : ExpectationChain<Long> {
    return expect(target).toBeInRange(value - tolerance, value + tolerance)
}

public val Long.should : Should<Long> get() = Should(this)

fun Should<Long>.beGreaterOrEqualTo(val value: Long) : ShouldChain<Long> {
    expector.toBeGreaterOrEqualTo(value)
    return ShouldChain(this)
}

fun Should<Long>.beGreaterThan(val value: Long) : ShouldChain<Long> {
    expector.toBeGreaterThan(value)
    return ShouldChain(this)
}

fun Should<Long>.beLessOrEqualTo(val value: Long) : ShouldChain<Long> {
    expector.toBeLessOrEqualTo(value)
    return ShouldChain(this)
}

fun Should<Long>.beLessThan(val value: Long) : ShouldChain<Long> {
    expector.toBeLessThan(value)
    return ShouldChain(this)
}

fun Should<Long>.beInRange(val lower: Long, val upper: Long) : ShouldChain<Long> {
    expector.toBeInRange(lower, upper)
    return ShouldChain(this)
}

fun Should<Long>.beApproximately(val value: Long, val tolerance: Long) : ShouldChain<Long> {
    expector.toBeApproximately(value, tolerance)
    return ShouldChain(this)
}