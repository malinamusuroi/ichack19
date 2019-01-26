import React from 'react';
import { Card, Avatar } from 'react-native-elements';
import {
    StyleSheet,
    Text,
    View,
} from 'react-native';

export class ProfileCard extends React.Component {

    render() {
        return (
            <View>
                <Card title='John Doe'>
                    <View  style={styles.avatar}>
                        <Avatar
                            size="xlarge"
                            rounded
                            icon={{ name: 'user', type: 'font-awesome' }}
                            onPress={() => console.log("Works!")}
                            activeOpacity={0.7}
                            containerStyle={{ flex: 5, alignContent: 'center' }} />
                        <Text style={styles.info}> Here is my bio </Text>
                    </View>
                </Card>
            </View >
        );
    }
}

const styles = StyleSheet.create({
    avatar: {
        justifyContent: 'center',
        alignItems: 'center',
    },
    info: {
        marginTop: 20,
        alignItems: 'center'
    }
});



