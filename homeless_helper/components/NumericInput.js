import React from 'react';
import { Text, StyleSheet, View, TouchableOpacity, TextInput } from 'react-native';

export class NumericInput extends React.Component {

    state = {
        amount: "5"
    }

    render() {
        return (
            <View style={styles.moneyContainer}>
                <TouchableOpacity style={styles.minusButton} onPress={this._substract}>
                    <Text style={styles.text}> - </Text>
                </TouchableOpacity>
                <TextInput style={styles.input} underlineColorAndroid="transparent"
                    placeholder={this.state.amount}
                    fontSize='26'
                    placeholderTextColor="grey"
                    numberOfLines={1}
                    value={this.state.amount}
                    onChange={(text) => this.setState({amount: text})}
                    >
                </TextInput>
                <TouchableOpacity style={styles.plusButton} onPress={this._add}>
                    <Text style={styles.text}> + </Text>
                </TouchableOpacity>
            </View>
        )
    }

    _substract = () => {
        previousAmount = "" + (parseFloat(this.state.amount) - 1)
        this.setState({ amount: previousAmount })
    }

    _add = () => {
        previousAmount = "" + (parseFloat(this.state.amount) + 1)
        this.setState({ amount: previousAmount })
    }
}

const styles = StyleSheet.create({
    input: {
        textAlign: 'center',
        borderBottomWidth: 2,
        width: 120,
        height: 30,
        borderBottomColor: '#c9efe6',
        marginLeft: 5,
        marginRight: 5
    },
    moneyContainer: {
        flexDirection: 'row', flexWrap: 'wrap',
        marginTop: 100,
        alignSelf: 'center'
    },
    text: {
        fontSize: 27,
        alignSelf: 'center'
    },
    minusButton: {
        justifyContent: 'center',
        alignContent: 'center',
        marginLeft: 40,
        backgroundColor: '#c9efe6',
        borderBottomLeftRadius: 24,
        borderBottomRightRadius: 24,
        borderTopLeftRadius: 24,
        borderTopRightRadius: 24,
        width: 45,
        height: 45,
    },
    plusButton: {
        justifyContent: 'center',
        alignContent: 'center',
        marginRight: 40,
        backgroundColor: '#c9efe6',
        borderBottomLeftRadius: 24,
        borderBottomRightRadius: 24,
        borderTopLeftRadius: 24,
        borderTopRightRadius: 24,
        width: 45,
        height: 45,
    },
    button: {
        backgroundColor: '#71C4E8',
        width: 230,
        height: 40,
        marginTop: 75,
        alignSelf: 'center',
        borderBottomLeftRadius: 8,
        borderBottomRightRadius: 8,
        borderTopLeftRadius: 8,
        borderTopRightRadius: 8,
        justifyContent: 'center',
        alignItems: 'center'
    },
    container: {
        flex: 1,
        paddingTop: 15,
        backgroundColor: '#fff',
    },
});